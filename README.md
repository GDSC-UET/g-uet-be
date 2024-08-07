# GDSC-UET Backend Service

### Git flow for BE members
- Không code trực tiếp lên main
- Sẽ có 1 nhánh là clone của main đó là BE_Release
- Ae sẽ tách nhánh ra từ main, tên nhánh của ae sẽ là (feature/ten_task) rồi code xong tạo pull request (PR) vào BE_Release, ghi rõ title PR về tính năng của ae (Cần chi tiết hơn thì ghi thêm vào phần description).
- Nếu bị ae bị conflict khi tạo PR vào BE_Release thì cách resolve là clone 1 nhánh từ BE_Release, tên có thể là "fix/resolve-conflict-<ten_task>-to-BE_Release" rồi merge nhánh của ae vào, sau khi resolve conflict thì tạo PR từ nhánh resolve conflict của vào BE_Release.
- Branch name convention:
- 'feature/task_name': Khi làm 1 tính năng mới
- 'update/task_name': Khi update 1 tính năng
- 'fix/task_name': Khi fix 1 tính năng
- Commit message convention '<type>: <subject>'
- 'feat: message' :khi commit code 1 tính năng mới
- 'fix: message' :khi commit code fix 1 tính năng
- 'docs: message' : khi sửa những thứ không liên quan đến logic code
- 'config: message' : Khi sửa những thứ ở file config
- 'feat-fix-...: message' khi lần commit đó có cả các type khác
### Tools
- Docker
- IntelliJ IDEA
- Postman
- MongoDB Compass
- Git
- Github

### Run project
- Clone project về máy
- Mở terminal và chạy lệnh `docker-compose up`
- Mở project bằng IntelliJ IDEA
- Chạy project bằng IntelliJ IDEA
