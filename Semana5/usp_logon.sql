

alter procedure usp_logon(
	@usuario varchar(15),
	@clave varchar(15),
	@estado int out
) as
begin
	declare @cont int;
	select @cont = count(1)
		from empleado e 
		join Asignado a on e.chr_emplcodigo = a.chr_emplcodigo
		where e.vch_emplusuario=@usuario and e.vch_emplclave=@clave
		and a.dtt_asigfechabaja is null;
	set @estado = iif(@cont=1,1,-1);
end;
go


select * from eurekabank..empleado;

declare @estado int;
exec usp_logon 'lcastro', 'flaca', @estado out;
print @estado
go