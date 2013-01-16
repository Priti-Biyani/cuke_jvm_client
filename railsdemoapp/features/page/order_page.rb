module Page
 
 module OrderPage


 def navigate_to_url(url)

  visit url

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
   $url= current_url
   $order_id=$url.split("/").last
   #$Response = "order_id :"+$order_id
   puts "<TaaS Response Start>{\"order_id\":"+$order_id+"}<TaaS Response Complete>"
   # puts $Response.to_json
 end


 end
end

World(Page::OrderPage)

