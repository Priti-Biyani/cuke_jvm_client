
def status_updated?()
  page.has_content?("Delivered")
end

def navigate_to_display(url)

  visit url

end