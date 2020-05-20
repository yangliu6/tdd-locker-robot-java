### Locker Robot Tasking

#### Tasking

1. 存包

   - [ ] Given Robot管理一个locker,容量大于0 When 存包，Then 存包成功且出票
   - [ ] Given Robot管理三个lockers，第一个容量不为0，剩下两个大于0，When 存包，Then 包成功存入第二个locker且出票
   - [ ] Given Robot管理的lockers都满了，When 存包，Then 提示用户柜子满了

2. 取包

   - [ ] Given 提供正确的Ticket给Robot, When 取包, Then 成功取出第一个柜子中对应的包
   - [ ] Given 提供正确的Ticket给Robot, When 取包, Then 成功取出第二个柜子中对应的包
   - [ ] Given给的Ticket是伪造的 When取包 Then 无法取包并提示无效票
   - [ ] Given过期Ticket When取包 Then 无法取包并提示无效票
