require "taas"
namespace :taas do
 desc 'Start the TaaS Server'
 task :start_server do
  TaaS.start_server(ENV['contract_file'])
 end
end

