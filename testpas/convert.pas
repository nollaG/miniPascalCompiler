program convert;
#define ASCII_0 48
#define ASCII_SLASH_N 10
var
	a:array[1..20] of integer;
	num:integer;
	k,i:integer;

begin
	num:=237;
	k:=1;
	while num<>0 do begin
		a[k]:=num mod 2;
		k:=k+1;
		num:=num div 2;
	end;
	for i:=k-1 downto 1 do begin
		writeln(a[i]+ASCII_0);
	end;
	writeln(ASCII_SLASH_N);
	num:=128;
	k:=1;
	while num<>0 do begin
		a[k]:=num mod 10;
		k:=k+1;
		num:=num div 10;
	end;
	for i:=k-1 downto 1 do begin
		writeln(a[i]+ASCII_0);
	end;
	writeln(ASCII_SLASH_N);
end.
	