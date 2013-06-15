program rec;

type testrec=record
    a	:integer;
    b	:integer;
end;

var
	otestrec	:testrec;
function testss(var c:testrec):integer;
begin
	testss:=c.a;
	c.b:=52;
end;

begin
	otestrec.a:=48;
	otestrec.b:=50;
	writeln(otestrec.a,10);
	writeln(testss(&otestrec),10);
	writeln(otestrec.b,10);
	
end.
