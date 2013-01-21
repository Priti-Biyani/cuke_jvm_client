module Domain

  module Cuke


    def verify_order_delivered()
      assert status_updated?(),"Delivered"

    end

  end
end

World(Domain::Cuke)
