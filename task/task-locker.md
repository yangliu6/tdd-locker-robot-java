### Locker Tasking

#### Tasking

1. 存包

   - [X] Given柜子有空余 When存包 Then存包成功并出票
   - [X] Given柜子满了 When存包 Then失败且不出票

2. 取包

   - [X] Given给正确的Ticket When取包 Then成功取出对应的包
   - [X] Given给的Ticket是伪造的 When取包 Then无法取包
   - [X] Given过期Ticket When取包 Then无法取包