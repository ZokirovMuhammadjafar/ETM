package uz.elmurodov.ui.project;


import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Input;


/**
 * @author Saydali Murodullayev, Thu 12:30 PM. 1/13/2022
 */
public class ProjectUI extends BaseAbstractUI implements BaseUI {

    @Override
    public void create() {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ProjectCreateDto dto = new ProjectCreateDto();
        dto.setName(Input.getStr("Enter name: "));
        dto.setDescription(Input.getStr("Enter description: "));
        dto.setTz(Input.getStr("Enter details about your project: "));
        dto.setOrganization_id(SecurityHolder.session.getOrganization().getId());
        ResponseEntity<Data<?>> response = projectService.create(dto);
        show(response);
    }

    @Override
    public void block() {
        ProjectService service = UNIContainer.getBean(ProjectService.class);
        listOfUnblockProjects(SecurityHolder.session.getOrganization().getId());
        String projectName = Input.getStr("Enter project name which you want to block: ");
        ResponseEntity<Data<?>> response = service.block(projectName);
        show(response);

    }

    private void listOfUnblockProjects(int id) {

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
