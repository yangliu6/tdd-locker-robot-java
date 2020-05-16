### Locker Robot Tasking

#### Tasking

1. 存包

   - [ ] Given Robot管理一个locker When 存包，Then 存包成功且出票
   - [ ] Given Robot管理多个lockers，When 存包，Then 包成功存入第一个有空闲的locker且出票
   - [ ] Given Robot管理的lockers都满了，When 存包，Then 提示用户柜子满了

2. 取包

   - [ ] Given 提供正确的Ticket给Robot, When 取包, Then 成功取出对应的包
   - [ ] Given给的Ticket是伪造的 When取包 Then 无法取包并提示无效票
   - [ ] Given过期Ticket When取包 Then 无法取包并提示无效票
