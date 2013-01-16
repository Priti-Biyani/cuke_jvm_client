class OrderController < ApplicationController

  def new
    @items = Item.all
  end

  def create
    order = Order.create(:item_id => params[:item_id], :quantity => params[:quantity],:customer_name => params[:customer_name], :address => params[:address], :status=> 'New')
    redirect_to :action => :display, :id => order.id
  end

  def show
    @order = Order.find(params[:id])
    @item = Item.find(@order.item_id)
    render :json => {:order_id => @order.id , :item_name => @item.name , :status => @order.status, :quantity => @order.quantity, :address => @order.address, :customer_name => @order.customer_name}
  end

  def update
    @order = Order.find(params[:id])
    @order.status=params[:status]
    @order.save!
  end

  def display
    @order = Order.find(params[:id])

  end

end
