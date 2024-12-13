package com.example.alumnoyproducto.alumno;

public record AlumnoDTO(
        String nombre,
        String apellidos,
        String email,
        Curso curso,
        Direccion direccion
) {

    //Método para convertir un AlumnoDTO en un Alumno
    public static AlumnoDTO toAlumno(Alumno alumno) {
        String apellidos = alumno.getApellido1() + " " + alumno.getApellido2();
        return new AlumnoDTO(
                alumno.getNombre(),
                apellidos,
                alumno.getEmail(),
                alumno.getCurso(),
                alumno.getDireccion()
        );
    }
}

