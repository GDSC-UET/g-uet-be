# GDSC-UET BACKEND SERVICE

# Git flow for ae BE
- Không code trực tiếp lên main
- Sẽ có 1 nhánh là clone của main đó là BE_Release
- Ae sẽ tách nhánh ra từ main, tên nhánh của ae sẽ là (feature/ten_task) rồi code xong tạo pull request (PR) vào BE_Release.
- Nếu bị ae bị conflict khi tạo PR vào BE_Release thì cách resolve là clone 1 nhánh từ BE_Release, tên có thể là "fix/resolve-conflict-<ten_task>-to-BE_Release" rồi merge nhánh của ae vào, sau khi resolve conflict thì tạo PR từ nhánh resolve conflict của vào BE_Release.
