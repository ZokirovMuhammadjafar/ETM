package uz.elmurodov.ui.column;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Input;

/**
 * @author Saydali Murodullayev, Wed 1:21 AM. 1/19/2022
 */
public class ColumnUI extends BaseAbstractUI implements BaseUI {

    @Override
    public void create() {
        ColumnService columnService = UNIContainer.getBean(ColumnService.class);
        ColumnCreateDto column = new ColumnCreateDto();

        column.setName(Input.getStr("Enter name: "));
        column.setEmoji(Input.getStr("Enter emoji: "));


    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void list() {

    }
}
