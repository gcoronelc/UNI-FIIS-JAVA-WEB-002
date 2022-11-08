

alter procedure usp_deposito
(
	@cuenta char(8),
	@importe money,
	@usuario varchar(15),
	@estado int out,
	@mensaje varchar(2000) out
)
as
begin
	DECLARE @contMov int, @empleado char(4); 
	set @estado = 0;
	set @mensaje = 'Proceso ejecutado correctamente.';
	BEGIN TRY 
		-- Inicio de Tx
		BEGIN TRANSACTION;

		-- Datos del empleado
		select @empleado=chr_emplcodigo from empleado
		where vch_emplusuario=@usuario;
		-- Datos de la cuenta
		select @contMov = int_cuencontmov 
		from cuenta where chr_cuencodigo = @cuenta;
		-- Final de proceso
		set @contMov = @contMov + 1;
		update cuenta 
		set int_cuencontmov = @contMov, dec_cuensaldo = dec_cuensaldo + @importe 
		where chr_cuencodigo = @cuenta;
		insert into movimiento(chr_cuencodigo, int_movinumero, dtt_movifecha,
		chr_emplcodigo, chr_tipocodigo,dec_moviimporte) 
		values(@cuenta,@contMov,getdate(),@empleado,'003',@importe);
		-- Confirmacion de Tx
		COMMIT TRANSACTION; 
	END TRY 
	BEGIN CATCH 
		if( @estado=0 )
		begin
			set @estado = 1;
			set @mensaje = 'Error en el proceso.';
		end;
		ROLLBACK TRANSACTION;
	END CATCH;
end;
go

select * from cuenta where chr_cuencodigo='00100001';
select * from movimiento where chr_cuencodigo='00100001';
go

declare @estado int, @mensaje varchar(2000);
exec usp_deposito '00100001', 1000, 'lcastro', @estado out, @mensaje out;
print cast(@estado as varchar(2000)) + ' - ' + @mensaje;
go
