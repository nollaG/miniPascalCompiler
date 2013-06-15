program test;



function testret(i:integer):integer;
begin
	if (i=0) then
		testret:=0
	else
		testret:=testret(i-1)+i;
end;


begin
	writeln(testret(10),10);
end.
