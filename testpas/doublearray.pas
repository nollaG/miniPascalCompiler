program doublearray;
var
	a : array[1..10,1..10] of integer;
	i,sum :integer;

begin
	for i:=1 to 10 do
		a[i,i]:=i;
	sum:=0;
	for i:=1 to 10 do
		sum:=sum+a[i,i];
	writeln(sum,10);
end.