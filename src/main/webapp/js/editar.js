function cambiare(e,cod,est,cont){
    e.preventDefault();
    console.log(cod);
    console.log(est);
    console.log(cont);

    Swal.fire({
        title: 'Esta seguro de cambiar el estado?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, Cambialo!',
        cancelButtonText: "No, Cancelar!",
    }).then((result) => {
        if (result.isConfirmed)
        {
            if(est==true)
                window.setTimeout(function()
                    {window.location.href = cont+"Controller?accion=changeEstado&id="+cod+"&es=false"}
                    ,2000);
            else
                window.setTimeout(function()
                    {window.location.href = cont+"Controller?accion=changeEstado&id="+cod+"&es=true"}
                    ,2000);

            Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: 'El estado ha sido cambiado',
                showConfirmButton: false,
                timer: 1500
            })

        } else {
            Swal.fire(
                'Cancelado',
                'Cancelaste la eliminacion',
                'error');
        }

    });


};