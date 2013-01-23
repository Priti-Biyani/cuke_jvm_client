module Page
  module PageOrder

  def navigate_to_url(order_id)
      visit "http://localhost:3000/order/display/"+order_id
  end

  def status_updated?()
  page.has_content?("Delivered")
  end

  end
end

World(Page::PageOrder)