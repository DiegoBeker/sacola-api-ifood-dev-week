package me.dio.sacola.resource;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@Api(value="/ifood-devweek/sacolas")
@RestController
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class SacolaResource {
  private final SacolaService sacolaService;

  @PostMapping
  public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
    return sacolaService.incluirItemNaSacola(itemDto);
  }

  @GetMapping("/{id}")
  public Sacola verSacola(@PathVariable("id") Long id) {
    return sacolaService.verSacola(id);
  }

  @PatchMapping("/fecharSacola/{sacolaId}")
  public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId,
                             @RequestParam("formaPagamento") int formaPagamento) {
    return sacolaService.fecharSacola(sacolaId, formaPagamento);
  }

  @PatchMapping("/excluirItem")
  public Sacola excluirItemDaSacola(@RequestBody ItemDto itemDto) {
    return sacolaService.excluirItemDaSacola(itemDto);
  }

  @PatchMapping("/limparSacola/{sacolaId}")
  public Sacola limparSacola(@PathVariable("sacolaId") Long sacolaId) {
    return sacolaService.limparSacola(sacolaId);
  }

  @DeleteMapping("/excluirSacola/{sacolaId}")
  public void excluirSacola(@PathVariable("sacolaId") Long id){
    sacolaService.excluirSacola(id);
  }
}
