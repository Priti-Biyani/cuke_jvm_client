Given /^I visit the order status page$/ do
 navigate_to_url(ENV["order_id"])
end


Then /^I should view order delivered status$/ do
  assert_order_delivered()
end

