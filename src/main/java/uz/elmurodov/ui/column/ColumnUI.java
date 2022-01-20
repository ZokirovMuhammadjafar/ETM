package uz.elmurodov.ui.column;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnDeleteDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Input;

/**
 * @author Saydali Murodullayev, Wed 1:21 AM. 1/19/2022
 */
public class ColumnUI extends BaseAbstractUI implements BaseUI {

    ColumnService columnService = UNIContainer.getBean(ColumnService.class);

    @Override
    public void create() {
        ColumnCreateDto column = new ColumnCreateDto();

        column.setName(Input.getStr("Enter name: "));
        column.setEmoji(Input.getStr("Enter emoji: "));
        ResponseEntity<Data<?>> response = columnService.create(column);
        show(response);
    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }

    @Override
    public void delete() {
        ColumnDeleteDto column = new ColumnDeleteDto();

        column.setColumnId(Input.getNum("Enter columnID please: ").longValue());

        ResponseEntity<Data<?>> response = columnService.delete(column);
        show(response);
    }

    @Override
    public void update() {

    }

    @Override
    public void list() {
        ColumnDeleteDto column = new ColumnDeleteDto();

        column.setColumnId(Input.getNum("Enter columnID please: ").longValue());

        ResponseEntity<Data<?>> response = columnService.list(column);
        show(response);

    }


}
