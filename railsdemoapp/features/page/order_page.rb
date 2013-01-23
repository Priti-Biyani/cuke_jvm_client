module Page
 module OrderPage

 def navigate_to_merchant_site()
  visit "http://localhost:3000"
 end

 def fill_form(name,quantity,address)
   fill_in("customer_name", :with => name)
   fill_in("quantity", :with => quantity)
   fill_in("address", :with => address)
end

 def submit_form()
       click_button("Place Order")
 end

 def status_message_is_displayed?()
     page.has_content?("New")
 end

 def get_order_id_from_url()

   $order_id=current_url.split("/").last
   puts "<TaaS Response Start>{\"order_id\":"+$order_id+"}<TaaS Response Complete>"
 end

 end
end

World(Page::OrderPage)

