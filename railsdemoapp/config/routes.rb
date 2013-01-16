Ordermerchant::Application.routes.draw do
  resources :items

  get "/", :to => "order#new"
  get "/order/new" => "order#new"
  post "/order/create" => "order#create"
  post "/order/update/:id" => "order#update"
  get "/order/show/:id" => "order#show"
  get "/order/display/:id" => "order#display", :as => :order_display
end
