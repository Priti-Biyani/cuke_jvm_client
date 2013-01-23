module Domain
  module Cuke

    def navigate_to_url(order_id)
    puts order_id
    end

    def assert_order_delivered()
      assert status_updated?(),"Delivered"
    end

  end
end

World(Domain::Cuke)
