program varParameter;
var
	i		:integer;

procedure change(var i:integer);
begin
	i:=3+48;
end;

begin
	i:=48;
	writeln(i,10);
	change(&i);
	writeln(i,10);
	
end.