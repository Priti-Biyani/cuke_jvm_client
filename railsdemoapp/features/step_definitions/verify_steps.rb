Given /^I visit the order status page$/ do
  $order_id=ENV["order_id"]
  puts $order_id
  visit "http://localhost:3000/order/display/"+$order_id
end


xThen /^I should see order delivered status$/ do
  verify_order_delivered()
end

