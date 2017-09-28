package mx.com.example.test.utilidades;

import mx.com.example.test.dto.entity.Empleado;

import java.lang.reflect.Method;

public class ReflectionManager {

    public static Method getClassMethod(Class classType, String methodName, Class... parametersType)  {
        Method metodo = null;
        try {
            metodo = classType.getDeclaredMethod(methodName, parametersType);
        }
        catch (Exception e) {

        }

        return metodo;
    }

    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        Class clase = empleado.getClass();
    }
}
