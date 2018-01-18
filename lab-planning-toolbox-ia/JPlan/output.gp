
Proposition Layer
Proposition: OnTable(a1)
 Mutex with: 
Proposition: Clear(b1)
 Mutex with: 
Proposition: Clear(a1)
 Mutex with: 
Proposition: OnTable(b1)
 Mutex with: 
 Action Layer
noopClear(a1)
 Mutex With: Pickup ( a1 ), 
noopOnTable(a1)
 Mutex With: Pickup ( a1 ), 
Pickup ( b1 )
 Mutex With: noopClear(b1), noopOnTable(b1), 
Pickup ( a1 )
 Mutex With: noopClear(a1), noopOnTable(a1), 
noopClear(b1)
 Mutex With: Pickup ( b1 ), 
noopOnTable(b1)
 Mutex With: Pickup ( b1 ), 
Proposition Layer
Proposition: OnTable(a1)
 Mutex with: Holding(a1), 
Proposition: Holding(a1)
 Mutex with: OnTable(a1), Clear(a1), 
Proposition: Clear(b1)
 Mutex with: Holding(b1), 
Proposition: Clear(a1)
 Mutex with: Holding(a1), 
Proposition: OnTable(b1)
 Mutex with: Holding(b1), 
Proposition: Holding(b1)
 Mutex with: Clear(b1), OnTable(b1), 
 Action Layer
noopClear(b1)
 Mutex With: Stack ( b1, b1 ), Putdown ( b1 ), Stack ( a1, b1 ), Stack ( b1, a1 ), Pickup ( b1 ), noopHolding(b1), 
Stack ( b1, b1 )
 Mutex With: noopClear(b1), Putdown ( b1 ), Stack ( a1, b1 ), Stack ( b1, a1 ), noopOnTable(b1), Pickup ( b1 ), noopHolding(b1), 
Putdown ( b1 )
 Mutex With: noopClear(b1), Stack ( b1, b1 ), Stack ( a1, b1 ), Stack ( b1, a1 ), noopOnTable(b1), Pickup ( b1 ), noopHolding(b1), 
Stack ( a1, b1 )
 Mutex With: noopClear(b1), Stack ( b1, b1 ), Putdown ( b1 ), noopOnTable(a1), Stack ( b1, a1 ), Putdown ( a1 ), Stack ( a1, a1 ), noopHolding(a1), Pickup ( b1 ), noopClear(a1), noopHolding(b1), Pickup ( a1 ), 
noopOnTable(a1)
 Mutex With: Stack ( a1, b1 ), Putdown ( a1 ), Stack ( a1, a1 ), noopHolding(a1), Pickup ( a1 ), 
Stack ( b1, a1 )
 Mutex With: noopClear(b1), Stack ( b1, b1 ), Putdown ( b1 ), Stack ( a1, b1 ), noopOnTable(b1), Putdown ( a1 ), Stack ( a1, a1 ), noopHolding(a1), Pickup ( b1 ), noopClear(a1), noopHolding(b1), Pickup ( a1 ), 
noopOnTable(b1)
 Mutex With: Stack ( b1, b1 ), Putdown ( b1 ), Stack ( b1, a1 ), Pickup ( b1 ), noopHolding(b1), 
Putdown ( a1 )
 Mutex With: Stack ( a1, b1 ), noopOnTable(a1), Stack ( b1, a1 ), Stack ( a1, a1 ), noopHolding(a1), noopClear(a1), Pickup ( a1 ), 
Stack ( a1, a1 )
 Mutex With: Stack ( a1, b1 ), noopOnTable(a1), Stack ( b1, a1 ), Putdown ( a1 ), noopHolding(a1), noopClear(a1), Pickup ( a1 ), 
noopHolding(a1)
 Mutex With: Stack ( a1, b1 ), noopOnTable(a1), Stack ( b1, a1 ), Putdown ( a1 ), Stack ( a1, a1 ), noopClear(a1), Pickup ( a1 ), 
Pickup ( b1 )
 Mutex With: noopClear(b1), Stack ( b1, b1 ), Putdown ( b1 ), Stack ( a1, b1 ), Stack ( b1, a1 ), noopOnTable(b1), noopHolding(b1), 
noopClear(a1)
 Mutex With: Stack ( a1, b1 ), Stack ( b1, a1 ), Putdown ( a1 ), Stack ( a1, a1 ), noopHolding(a1), Pickup ( a1 ), 
noopHolding(b1)
 Mutex With: noopClear(b1), Stack ( b1, b1 ), Putdown ( b1 ), Stack ( a1, b1 ), Stack ( b1, a1 ), noopOnTable(b1), Pickup ( b1 ), 
Pickup ( a1 )
 Mutex With: Stack ( a1, b1 ), noopOnTable(a1), Stack ( b1, a1 ), Putdown ( a1 ), Stack ( a1, a1 ), noopHolding(a1), noopClear(a1), 
Proposition Layer
Proposition: Holding(a1)
 Mutex with: Clear(a1), On(a1,a1), On(a1,b1), On(b1,a1), OnTable(a1), 
Proposition: Clear(a1)
 Mutex with: Holding(a1), On(b1,a1), 
Proposition: Holding(b1)
 Mutex with: Clear(b1), On(a1,b1), On(b1,a1), On(b1,b1), OnTable(b1), 
Proposition: Clear(b1)
 Mutex with: Holding(b1), On(a1,b1), 
Proposition: On(a1,a1)
 Mutex with: Holding(a1), On(a1,b1), On(b1,a1), OnTable(a1), 
Proposition: On(a1,b1)
 Mutex with: Holding(a1), Holding(b1), Clear(b1), On(a1,a1), On(b1,a1), OnTable(a1), On(b1,b1), 
Proposition: On(b1,a1)
 Mutex with: Holding(a1), Clear(a1), Holding(b1), On(a1,a1), On(a1,b1), On(b1,b1), OnTable(b1), 
Proposition: OnTable(a1)
 Mutex with: Holding(a1), On(a1,a1), On(a1,b1), 
Proposition: On(b1,b1)
 Mutex with: Holding(b1), On(a1,b1), On(b1,a1), OnTable(b1), 
Proposition: OnTable(b1)
 Mutex with: Holding(b1), On(b1,a1), On(b1,b1), 