
def status_updated?()
  page.has_content?("Delivered")
end

def navigate_to_url(url)

  visit url

end