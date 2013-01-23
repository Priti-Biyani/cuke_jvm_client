module Domain
 module CukeOrder

 def navigate_to_homepage()
  navigate_to_merchant_site()
 end

 def place_an_order(name,quantity,address)
  fill_form(name,quantity,address)
  submit_form()
 end

 def assert_order_placed()
   assert status_message_is_displayed?()
 end

 def get_order_id()
   get_order_id_from_url()
 end

 end
end

World(Domain::CukeOrder)
