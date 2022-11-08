-- 1. Requerimiento
/*
Reporte de depositos y retiros por sucursal de los ultimos 7 dias.
*/

create procedure usp_resumen_operaciones
( @dias int )
as
begin
	select 
		v.SUCUNOMBRE SUCURSAL,
		SUM(IIF(v.tipoaccion='INGRESO',v.moviimporte,0)) INGRESO,
		SUM(IIF(v.tipoaccion='SALIDA',v.moviimporte,0)) SALIDA
	from dbo.v_movimiento v
	where DATEDIFF ( day , v.movifecha , GETDATE() )  <= @dias
	group by v.SUCUNOMBRE
end;
go

SELECT DATEDIFF ( day , v.movifecha , GETDATE() ) FROM V_MOVIMIENTO v;

exec usp_resumen_operaciones 300;

