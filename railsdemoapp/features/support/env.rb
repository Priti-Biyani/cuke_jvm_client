require 'cucumber/rails'

DatabaseCleaner.strategy = nil
Cucumber::Rails::Database.javascript_strategy = :transaction
ActionController::Base.allow_rescue = false
Capybara.default_selector = :css
Capybara.javascript_driver = :selenium

