module NavigationHelpers

  def path_to(page_name)
    case page_name
      when /new order page/
        order_new_path
    end
  end
end
World(NavigationHelpers)