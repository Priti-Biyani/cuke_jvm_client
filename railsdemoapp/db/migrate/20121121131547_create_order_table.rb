class CreateOrderTable < ActiveRecord::Migration
  def change
    create_table :orders do |t|
      t.string :item_id
      t.string :customer_name
      t.string :status
      t.integer :quantity
      t.text :address

      t.timestamps
    end

  end

end
