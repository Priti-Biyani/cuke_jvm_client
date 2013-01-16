
module Domain

 module CukeOrder


 def navigate_to_homepage(url)

  navigate_to_url(url)

 end



 def place_an_order(name,quantity,address)
   
  fill_form(name,quantity,address)
  submit_form()
 end


 def verify_order_placed()
  
   assert status_message_is_displayed?(),"order not placed"
   #get_order_id_from_url()

 end

 def get_orderid()
   get_order_id_from_url()
 end



 end
end

World(Domain::CukeOrder)
