
Given /^I visit the order merchant site$/ do
    navigate_to_homepage()
end

When /^I place an order$/ do
  place_an_order(ENV["name"],ENV["quantity"],ENV["address"])
end

Then /^order should get placed successfully$/ do
  assert_order_placed()
  get_order_id()
end


