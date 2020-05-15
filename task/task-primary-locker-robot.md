### Locker Robot Tasking

#### Tasking

1. 存包

   - [ ] Given柜子没满 When存包 Then按顺序存包且出票
   - [ ] Given用户刚取走一个包，When存包，Then按顺序存包且出票
   - [ ] Given柜子满了 When存包 Then提示用户柜子满了且不出票

2. 取包

   - [ ] Given给正确的Ticket When取包 Then成功取出对应的包
   - [ ] Given给的Ticket是伪造的 When取包 Then无法取包
   - [ ] Given过期Ticket When取包 Then无法取包