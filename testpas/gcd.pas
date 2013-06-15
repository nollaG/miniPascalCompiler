program gcd;


function gcd(a,b:integer):integer;
begin
    if b=0 then
        gcd:=a
    else
        gcd:=gcd(b,a mod b);
end;




begin
    writeln(gcd(64,24)+48,10);
end.
