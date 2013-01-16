
Given /^I visit the order merchant site$/ do
 
    navigate_to_homepage("http://localhost:3000")

end

When /^I place an order$/ do

  place_an_order(ENV["name"],ENV["quantity"],ENV["address"])
  
end

Then /^order should get placed successfully$/ do

 verify_order_placed()
  get_orderid()
end


