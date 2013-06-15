program factorial;
#define ASCII_0 48

function fact(i:integer):integer;
begin
	if i=1 then
		fact:=1
	else
		fact:=fact(i-1)*i;
end;

procedure outputNum(num:integer);
var
	a	:array[1..20] of integer;
	i,k  :integer;
begin
	k:=1;
	while num<>0 do begin
		a[k]:=num mod 10;
		k:=k+1;
		num:=num div 10;
	end;
	for i:=k-1 downto 1 do
		writeln(ASCII_0+a[i]);
	writeln(10);
end;





begin
    outputNum(fact(4));
    outputNum(fact(10));
end.
