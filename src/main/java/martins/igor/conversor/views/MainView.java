package martins.igor.conversor.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    public MainView() {

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Componentes
        NumberField input = new NumberField();
        input.setPlaceholder("Valor");

        NumberField output = new NumberField();
        output.setReadOnly(true);

        Button conversorButton = new Button("Converter");

        ComboBox<String> boxInput = new ComboBox<>();
        boxInput.setPlaceholder("Medidas");
        boxInput.setItems(
            "Quilômetro",
            "Metro",
            "Centímetro",
            "Milímetro",
            "Milha",
            "Jarda",
            "Pé",
            "Polegada"
        );

        ComboBox<String> boxOutput = new ComboBox<>();
        boxOutput.setPlaceholder("Medidas");
        boxOutput.setItems(
            "Quilômetro",
            "Metro",
            "Centímetro",
            "Milímetro",
            "Milha",
            "Jarda",
            "Pé",
            "Polegada"
        );

        // Notificações
        Notification alertValorInvalido = new Notification(
            "",
            3000,
            Notification.Position.TOP_CENTER
        );

        Text textoValorInvalido = new Text("O valor não pode estar vazio ou ser negativo.");

        Notification alertMedidaInvalida = new Notification(
                "",
                3000,
                Notification.Position.TOP_CENTER
        );

        Text textoMedidaInvalida = new Text("É preciso selecionar as duas medidas para conversão.");

        alertValorInvalido.addThemeVariants(NotificationVariant.LUMO_WARNING);
        alertMedidaInvalida.addThemeVariants(NotificationVariant.LUMO_WARNING);

        Button closeAlertButton = new Button(new Icon("lumo", "cross"));
        closeAlertButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeAlertButton.getElement().setAttribute("aria-label", "Close");
        closeAlertButton.addClickListener(event -> {
            alertMedidaInvalida.close();
            alertValorInvalido.close();
        });

        // Lógica da aplicação
        conversorButton.addClickListener(click -> {

            String inputUnidade = boxInput.getValue();
            String outputUnidade = boxOutput.getValue();

            Double inputValue = input.getValue() != null ? input.getValue() : 0.0;

            // Validação do input
            if (inputValue <= 0) {
                alertValorInvalido.add(textoValorInvalido, closeAlertButton);
                alertValorInvalido.open();
                return;
            }

            // Validação das medidas
            if (inputUnidade == null || outputUnidade == null) {
                alertMedidaInvalida.add(textoMedidaInvalida, closeAlertButton);
                alertMedidaInvalida.open();
                return;
            }

            // Lógica de conversão
            switch (inputUnidade) {

                case "Quilômetro":
                    switch(outputUnidade) {
                        case "Metro":
                            output.setValue(inputValue * 1000);
                            break;

                        case "Centímetro":
                            output.setValue(inputValue * 100000);
                            break;

                        case "Milímetro":
                            output.setValue(inputValue * 1000000);
                            break;

                        case "Milha":
                            output.setValue(inputValue / 1.609);
                            break;

                        case "Jarda":
                            output.setValue(inputValue * 1094);
                            break;

                        case "Pé":
                            output.setValue(inputValue * 3281);
                            break;

                        case "Polegada":
                            output.setValue(inputValue * 39370);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }

                case "Metro":
                    switch(outputUnidade) {
                        case "Quilômetro":
                            output.setValue(inputValue / 1000);
                            break;

                        case "Centímetro":
                            output.setValue(inputValue * 100);
                            break;

                        case "Milímetro":
                            output.setValue(inputValue * 1000);
                            break;

                        case "Milha":
                            output.setValue(inputValue / 1609);
                            break;

                        case "Jarda":
                            output.setValue(inputValue * 1.094);
                            break;

                        case "Pé":
                            output.setValue(inputValue * 3.281);
                            break;

                        case "Polegada":
                            output.setValue(inputValue * 39.37);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }

                case "Centímetro":
                    switch(outputUnidade) {
                        case "Quilômetro":
                            output.setValue(inputValue / 100000);
                            break;

                        case "Metro":
                            output.setValue(inputValue / 100);
                            break;

                        case "Milímetro":
                            output.setValue(inputValue * 10);
                            break;

                        case "Milha":
                            output.setValue(inputValue / 160900);
                            break;

                        case "Jarda":
                            output.setValue(inputValue / 91.44);
                            break;

                        case "Pé":
                            output.setValue(inputValue / 30.48);
                            break;

                        case "Polegada":
                            output.setValue(inputValue / 2.54);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }

                case "Milímetro":
                    switch(outputUnidade) {
                        case "Quilômetro":
                            output.setValue(inputValue / 1000000);
                            break;

                        case "Metro":
                            output.setValue(inputValue / 1000);
                            break;

                        case "Centímetro":
                            output.setValue(inputValue / 10);
                            break;

                        case "Milha":
                            output.setValue(inputValue / 0.000000621371);
                            break;

                        case "Jarda":
                            output.setValue(inputValue / 914.4);
                            break;

                        case "Pé":
                            output.setValue(inputValue / 304.8);
                            break;

                        case "Polegada":
                            output.setValue(inputValue / 25.4);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }

                case "Milha":
                    switch(outputUnidade) {
                        case "Quilômetro":
                            output.setValue(inputValue * 1.609);
                            break;

                        case "Metro":
                            output.setValue(inputValue * 1609);
                            break;

                        case "Centímetro":
                            output.setValue(inputValue * 160900);
                            break;

                        case "Milímetro":
                            output.setValue(inputValue * 1609000);
                            break;

                        case "Jarda":
                            output.setValue(inputValue * 1760);
                            break;

                        case "Pé":
                            output.setValue(inputValue * 5280);
                            break;

                        case "Polegada":
                            output.setValue(inputValue * 63360);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }

                case "Jarda":
                    switch(outputUnidade) {
                        case "Quilômetro":
                            output.setValue(inputValue / 1094);
                            break;

                        case "Metro":
                            output.setValue(inputValue / 1.094);
                            break;

                        case "Centímetro":
                            output.setValue(inputValue * 91.44);
                            break;

                        case "Milímetro":
                            output.setValue(inputValue * 914.4);
                            break;

                        case "Milha":
                            output.setValue(inputValue / 1760);
                            break;

                        case "Pé":
                            output.setValue(inputValue * 3);
                            break;

                        case "Polegada":
                            output.setValue(inputValue * 36);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }

                case "Pé":
                    switch(outputUnidade) {
                        case "Quilômetro":
                            output.setValue(inputValue / 3281);
                            break;

                        case "Metro":
                            output.setValue(inputValue / 3.281);
                            break;

                        case "Centímetro":
                            output.setValue(inputValue * 30.48);
                            break;

                        case "Milímetro":
                            output.setValue(inputValue * 304.8);
                            break;

                        case "Milha":
                            output.setValue(inputValue / 5280);
                            break;

                        case "Jarda":
                            output.setValue(inputValue / 3);
                            break;

                        case "Polegada":
                            output.setValue(inputValue * 12);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }

                case "Polegada":
                    switch(outputUnidade) {
                        case "Quilômetro":
                            output.setValue(inputValue / 39370);
                            break;

                        case "Metro":
                            output.setValue(inputValue / 39.37);
                            break;

                        case "Centímetro":
                            output.setValue(inputValue * 2.54);
                            break;

                        case "Milímetro":
                            output.setValue(inputValue * 25.4);
                            break;

                        case "Milha":
                            output.setValue(inputValue / 63360);
                            break;

                        case "Jarda":
                            output.setValue(inputValue / 36);
                            break;

                        case "Pé":
                            output.setValue(inputValue / 12);
                            break;

                        default:
                            output.setValue(inputValue);
                            break;
                    }
            }
        });
        conversorButton.addClickShortcut(Key.ENTER);

        // Alinhamento dos Componentes
        H1 title = new H1("Conversor de Unidades de Comprimento");
        HorizontalLayout inputLayout = new HorizontalLayout(input, boxInput);
        HorizontalLayout outputLayout = new HorizontalLayout(output, boxOutput);

        add(
            title,
            inputLayout,
            outputLayout,
            conversorButton
        );
    }
}