program HelloWorld;
var
	a		:array[1..11] of integer;
	i		:integer;


begin
	a[1]:=72; //H
	a[2]:=101; //e
	a[3]:=108; //l
	a[4]:=108; //l
	a[5]:=111; //o
	a[6]:=87; //W
	a[7]:=111; //o
	a[8]:=114; //r
	a[9]:=108; //l
	a[10]:=100; //d
	a[11]:=10; //\n
	for i:=1 to 11 do
		writeln(a[i]);
end.