program LongestIncreasingSubsequence;
#define TOTAL 10
#define ASCII_0 48
var
	i,j,max	:integer;
	a,f		:array[1..TOTAL] of integer;
	

	
procedure readnum(var num:integer);
var
	i			:integer;
begin
	num:=0;
	readln(i);
	while i<>10 do begin
		num:=num*10+i-ASCII_0;
		readln(i);
	end;
end;

procedure printnum(num:integer);
var
	a		:array[1..20] of integer;
	i,k		:integer;
begin
	k:=1;
	while (num<>0) do begin
		a[k]:=num mod 10;
		k:=k+1;
		num:=num div 10;
	end;
	for i:=k-1 downto 1 do
		writeln(a[i]+ASCII_0);
end;

function maxnum(a,b:integer):integer;
begin
	if a>b then
		maxnum:=a
	else
		maxnum:=b;
end;

begin
	for i:=1 to TOTAL do begin
		readnum(&a[i]);
	end;
	for i:=1 to TOTAL do begin
		f[i]:=1;
		for j:=1 to i-1 do begin
			if (a[j]<a[i]) then  //increase
				f[i]:=maxnum(f[i],f[j]+1);
		end;
		if (f[i]>max) then max:=f[i];
	end;
	writeln(10);
	printnum(max);
end.
	