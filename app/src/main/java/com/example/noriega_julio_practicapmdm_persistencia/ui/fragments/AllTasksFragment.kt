package com.example.noriega_julio_practicapmdm_persistencia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noriega_julio_practicapmdm_persistencia.R
import com.example.noriega_julio_practicapmdm_persistencia.data.model.Task
import com.example.noriega_julio_practicapmdm_persistencia.ui.adapters.TaskAdapter

class AllTasksFragment : Fragment() {

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_all_tasks, container, false)

        val allTasks = mutableListOf(
            Task(1, "Limpiar la casa", "Realizar una limpieza profunda de la casa, incluyendo baños, cocina y habitaciones.", 2),
            Task(2, "Preparar la comida", "Cocinar una cena saludable para toda la familia.", 3),
            Task(3, "Hacer la compra", "Comprar alimentos frescos para la semana en el supermercado.", 1),
            Task(4, "Comprar leche", "No olvides comprar leche desnatada y un litro de soja.", 3),
            Task(5, "Preparar cena", "Marinar el pollo para la barbacoa y picar las verduras para la ensalada.", 2),
            Task(6, "Leer libro", "Terminar el capítulo 10 de 'El nombre de la rosa' antes de dormir.", 1),
            Task(7, "Llamar a Marta", "Recordarle que nos vemos el sábado para ir al cine.", 3),
            Task(8, "Pagar factura", "Realizar el pago de la luz antes del día 10 para evitar recargos.", 2),
            Task(9, "Lavar ropa", "Separar la ropa blanca de la de color y poner una lavadora con agua fría.", 3),
            Task(10, "Entrenar", "Ir al gimnasio a las 18:00 para una sesión de pesas y cardio.", 1),
            Task(11, "Escribir correo electrónico", "Enviar un correo electrónico a mi jefe con el informe final del proyecto.", 2),
            Task(12, "Comprar regalo", "Encontrar un regalo de cumpleaños original para mi amigo Pedro.", 3),
            Task(13, "Organizar escritorio", "Limpiar y ordenar mi escritorio para tener un espacio de trabajo más eficiente.", 1),
            Task(14, "Ver película", "Ver la película '2012' en streaming con mi pareja.", 2),
            Task(15, "Cocinar pizza", "Preparar una pizza casera con masa madre y mozzarella fresca.", 3),
            Task(16, "Aprender una nueva habilidad", "Dedicar 30 minutos al día a aprender un nuevo idioma o tocar un instrumento musical.", 1),
            Task(17, "Planificar viaje", "Comenzar a planificar las vacaciones de verano, buscando vuelos y alojamiento.", 2),
            Task(18, "Visitar a mis padres", "Ir a casa de mis padres el fin de semana para pasar tiempo con ellos.", 3),
            Task(19, "Leer noticias", "Estar al día de la actualidad leyendo las noticias del día.", 1),
            Task(20, "Meditar", "Practicar meditación durante 10 minutos para mejorar la concentración y la calma.", 2)

        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.allTasksRecyclerView)
        taskAdapter = TaskAdapter(allTasks)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return rootView
    }
}
