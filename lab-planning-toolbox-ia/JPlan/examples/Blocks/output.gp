
Proposition Layer
Proposition: Clear(b1)
 Mutex with: 
Proposition: ON(b1,b2)
 Mutex with: 
Proposition: Clear(Table)
 Mutex with: 
Proposition: Clear(b3)
 Mutex with: 
Proposition: ON(b3,Table)
 Mutex with: 
Proposition: ON(b2,Table)
 Mutex with: 
 Action Layer
noopClear(b1)
 Mutex With: Move ( b3, Table, b1 ), 
noopON(b3,Table)
 Mutex With: Move ( b3, Table, b1 ), 
noopON(b2,Table)
 Mutex With: 
noopON(b1,b2)
 Mutex With: MoveToTable ( b1, b2 ), Move ( b1, b2, b3 ), 
MoveToTable ( b1, b2 )
 Mutex With: noopON(b1,b2), Move ( b1, b2, b3 ), Move ( b3, Table, b1 ), 
noopClear(b3)
 Mutex With: Move ( b1, b2, b3 ), 
Move ( b1, b2, b3 )
 Mutex With: noopON(b1,b2), MoveToTable ( b1, b2 ), noopClear(b3), Move ( b3, Table, b1 ), 
Move ( b3, Table, b1 )
 Mutex With: noopClear(b1), noopON(b3,Table), MoveToTable ( b1, b2 ), Move ( b1, b2, b3 ), 
noopClear(Table)
 Mutex With: 
Proposition Layer
Proposition: ON(b1,b2)
 Mutex with: ON(b1,Table), ON(b1,b3), Clear(b2), 
Proposition: Clear(b1)
 Mutex with: ON(b3,b1), 
Proposition: ON(b3,b1)
 Mutex with: Clear(b1), ON(b3,Table), ON(b1,Table), ON(b1,b3), Clear(b2), 
Proposition: ON(b3,Table)
 Mutex with: ON(b3,b1), 
Proposition: ON(b2,Table)
 Mutex with: 
Proposition: Clear(b3)
 Mutex with: ON(b1,b3), 
Proposition: ON(b1,Table)
 Mutex with: ON(b1,b2), ON(b3,b1), ON(b1,b3), 
Proposition: ON(b1,b3)
 Mutex with: ON(b1,b2), ON(b3,b1), Clear(b3), ON(b1,Table), 
Proposition: Clear(Table)
 Mutex with: 
Proposition: Clear(b2)
 Mutex with: ON(b1,b2), ON(b3,b1), 
 Action Layer
Move ( b3, Table, b1 )
 Mutex With: MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), noopClear(b1), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
MoveToTable ( b1, b3 )
 Mutex With: Move ( b3, Table, b1 ), Move ( b1, Table, b3 ), noopClear(b3), noopON(b1,Table), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
Move ( b1, Table, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), noopClear(b3), noopON(b1,Table), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
noopClear(b3)
 Mutex With: MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b1, b2, b3 ), noopON(b1,b3), 
noopON(b3,Table)
 Mutex With: Move ( b3, Table, b1 ), noopON(b3,b1), Move ( b3, Table, b2 ), Move ( b3, b1, b2 ), MoveToTable ( b3, b1 ), 
noopON(b1,Table)
 Mutex With: MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,b1), MoveToTable ( b1, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
noopClear(Table)
 Mutex With: 
noopClear(b1)
 Mutex With: Move ( b3, Table, b1 ), noopON(b3,b1), Move ( b2, Table, b1 ), Move ( b3, b1, b2 ), MoveToTable ( b3, b1 ), 
noopON(b3,b1)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), noopON(b1,Table), noopClear(b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
Move ( b2, Table, b1 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopClear(b1), noopON(b3,b1), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), 
MoveToTable ( b1, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b1,Table), noopON(b3,b1), Move ( b2, Table, b1 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
Move ( b3, Table, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
Move ( b1, Table, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b1,Table), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
noopON(b1,b2)
 Mutex With: MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), noopON(b1,b3), 
Move ( b2, Table, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopClear(b3), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
noopON(b2,Table)
 Mutex With: Move ( b2, Table, b1 ), Move ( b2, Table, b3 ), 
Move ( b1, b3, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopClear(b3), noopON(b1,Table), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
Move ( b3, b1, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), noopON(b1,Table), noopClear(b1), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), noopClear(b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), 
noopClear(b2)
 Mutex With: noopON(b3,b1), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), 
Move ( b1, b2, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopClear(b3), noopON(b1,Table), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), MoveToTable ( b3, b1 ), noopON(b1,b3), 
MoveToTable ( b3, b1 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), noopON(b1,Table), noopClear(b1), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), noopON(b1,b3), 
noopON(b1,b3)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopClear(b3), noopON(b1,Table), noopON(b3,b1), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), 
Proposition Layer
Proposition: ON(b3,b2)
 Mutex with: ON(b1,b2), ON(b3,b1), ON(b3,Table), ON(b2,b1), ON(b2,b3), ON(b1,b3), Clear(b2), 
Proposition: ON(b1,b2)
 Mutex with: ON(b3,b2), ON(b2,b1), ON(b1,Table), ON(b2,b3), ON(b1,b3), Clear(b2), 
Proposition: Clear(b1)
 Mutex with: ON(b3,b1), ON(b2,b1), 
Proposition: ON(b3,b1)
 Mutex with: ON(b3,b2), Clear(b1), ON(b3,Table), ON(b2,b1), ON(b2,b3), ON(b1,b3), 
Proposition: ON(b3,Table)
 Mutex with: ON(b3,b2), ON(b3,b1), 
Proposition: ON(b2,b1)
 Mutex with: ON(b3,b2), ON(b1,b2), Clear(b1), ON(b3,b1), ON(b2,Table), ON(b2,b3), 
Proposition: ON(b2,Table)
 Mutex with: ON(b2,b1), ON(b2,b3), 
Proposition: Clear(b3)
 Mutex with: ON(b2,b3), ON(b1,b3), 
Proposition: ON(b1,Table)
 Mutex with: ON(b1,b2), ON(b1,b3), 
Proposition: ON(b2,b3)
 Mutex with: ON(b3,b2), ON(b1,b2), ON(b3,b1), ON(b2,b1), ON(b2,Table), Clear(b3), ON(b1,b3), 
Proposition: ON(b1,b3)
 Mutex with: ON(b3,b2), ON(b1,b2), ON(b3,b1), Clear(b3), ON(b1,Table), ON(b2,b3), 
Proposition: Clear(Table)
 Mutex with: 
Proposition: Clear(b2)
 Mutex with: ON(b3,b2), ON(b1,b2), 
 Action Layer
Move ( b3, Table, b1 )
 Mutex With: MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
MoveToTable ( b2, b3 )
 Mutex With: Move ( b3, Table, b1 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b2, b1, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
MoveToTable ( b1, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopClear(b3)
 Mutex With: MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), noopON(b2,b3), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b1, b2, b3 ), noopON(b1,b3), 
Move ( b1, Table, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopON(b3,Table)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b3, b1, b2 ), noopON(b3,b2), MoveToTable ( b3, b1 ), 
noopON(b1,Table)
 Mutex With: MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), MoveToTable ( b1, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b1, b3, b2 ), Move ( b1, b2, b3 ), noopON(b1,b3), 
noopClear(Table)
 Mutex With: 
Move ( b2, b3, b1 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopClear(b1)
 Mutex With: Move ( b3, Table, b1 ), Move ( b2, b1, b3 ), Move ( b2, b3, b1 ), noopON(b3,b1), Move ( b2, Table, b1 ), Move ( b3, b2, b1 ), Move ( b3, b1, b2 ), noopON(b2,b1), MoveToTable ( b3, b1 ), MoveToTable ( b2, b1 ), 
MoveToTable ( b3, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopON(b3,b1)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b2, Table, b1 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), MoveToTable ( b2, b1 ), 
MoveToTable ( b1, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopON(b2,b3)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b3, Table, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b3, b2, b1 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b1, Table, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopON(b1,b2)
 Mutex With: MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b2, Table, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopON(b2,Table)
 Mutex With: MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), Move ( b2, b3, b1 ), Move ( b2, Table, b1 ), noopON(b2,b3), Move ( b2, Table, b3 ), noopON(b2,b1), MoveToTable ( b2, b1 ), 
Move ( b1, b3, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b3, b1, b2 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), noopClear(b2), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopClear(b2)
 Mutex With: MoveToTable ( b3, b2 ), MoveToTable ( b1, b2 ), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), 
noopON(b3,b2)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
Move ( b1, b2, b3 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopClear(b2), noopON(b3,b2), noopON(b2,b1), MoveToTable ( b3, b1 ), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopON(b2,b1)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), MoveToTable ( b2, b1 ), 
MoveToTable ( b3, b1 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), noopON(b3,Table), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), noopON(b1,b3), MoveToTable ( b2, b1 ), 
noopON(b1,b3)
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), noopClear(b3), Move ( b1, Table, b3 ), noopON(b1,Table), Move ( b2, b3, b1 ), MoveToTable ( b3, b2 ), noopON(b3,b1), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), MoveToTable ( b3, b1 ), 
MoveToTable ( b2, b1 )
 Mutex With: Move ( b3, Table, b1 ), MoveToTable ( b2, b3 ), Move ( b2, b1, b3 ), MoveToTable ( b1, b3 ), Move ( b1, Table, b3 ), Move ( b2, b3, b1 ), noopClear(b1), MoveToTable ( b3, b2 ), noopON(b3,b1), Move ( b2, Table, b1 ), MoveToTable ( b1, b2 ), noopON(b2,b3), Move ( b3, Table, b2 ), Move ( b3, b2, b1 ), Move ( b1, Table, b2 ), noopON(b1,b2), Move ( b2, Table, b3 ), noopON(b2,Table), Move ( b1, b3, b2 ), Move ( b3, b1, b2 ), noopON(b3,b2), Move ( b1, b2, b3 ), noopON(b2,b1), MoveToTable ( b3, b1 ), 
Proposition Layer
Proposition: ON(b3,b2)
 Mutex with: ON(b1,b2), ON(b3,b1), ON(b3,Table), ON(b2,b3), Clear(b2), 
Proposition: ON(b1,b2)
 Mutex with: ON(b3,b2), ON(b2,b1), ON(b1,Table), ON(b1,b3), Clear(b2), 
Proposition: Clear(b1)
 Mutex with: ON(b3,b1), ON(b2,b1), 
Proposition: ON(b3,b1)
 Mutex with: ON(b3,b2), Clear(b1), ON(b3,Table), ON(b2,b1), ON(b1,b3), 
Proposition: ON(b3,Table)
 Mutex with: ON(b3,b2), ON(b3,b1), 
Proposition: ON(b2,b1)
 Mutex with: ON(b1,b2), Clear(b1), ON(b3,b1), ON(b2,Table), ON(b2,b3), 
Proposition: ON(b2,Table)
 Mutex with: ON(b2,b1), ON(b2,b3), 
Proposition: Clear(b3)
 Mutex with: ON(b2,b3), ON(b1,b3), 
Proposition: ON(b1,Table)
 Mutex with: ON(b1,b2), ON(b1,b3), 
Proposition: ON(b2,b3)
 Mutex with: ON(b3,b2), ON(b2,b1), ON(b2,Table), Clear(b3), ON(b1,b3), 
Proposition: ON(b1,b3)
 Mutex with: ON(b1,b2), ON(b3,b1), Clear(b3), ON(b1,Table), ON(b2,b3), 
Proposition: Clear(Table)
 Mutex with: 
Proposition: Clear(b2)
 Mutex with: ON(b3,b2), ON(b1,b2), 