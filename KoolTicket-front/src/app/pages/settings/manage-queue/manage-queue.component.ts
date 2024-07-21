import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DndDropEvent, DndModule, DropEffect, EffectAllowed } from 'ngx-drag-drop';
import { polyfill } from 'mobile-drag-drop';
import { scrollBehaviourDragImageTranslateOverride } from "mobile-drag-drop/scroll-behaviour";
import { ButtonService } from '../../../services/button.service';
import { Boton } from '../../../core/domain';

interface DraggableItem { 
  // Se necesita estos atributos para hacer un drag & drop
  content: string;
  effectAllowed: EffectAllowed;
  disable: boolean;
  handle: boolean;
}
interface DropzoneLayout {
  container: string;
  list: string;
  dndHorizontal: boolean;
}
// Esto es para soportar en mobile
polyfill( {
  // use this to make use of the scroll behaviour
  dragImageTranslateOverride: scrollBehaviourDragImageTranslateOverride
} );

// workaround to make scroll prevent work in iOS Safari > 10
try {
  window.addEventListener( "touchmove", function() { }, { passive: false } );
}
catch(e){}

@Component({
  selector: 'app-manage-queue',
  standalone: true,
  imports: [CommonModule, DndModule],
  templateUrl: './manage-queue.component.html',
  styleUrl: './manage-queue.component.css'
})
export class ManageQueueComponent {

  _button:ButtonService = inject(ButtonService);
  buttons:Boton[] = [];
  buttonsList: DraggableItem[] = []

  ngOnInit(): void {
    this._button.getAllButtons().subscribe((data:any)=>{
        this.buttons = data;
        this.buttons = this.buttons.filter(b=>b.estado==true);
        this.buttons.forEach(btn => {
          // Asi es la erstructura para el Drag&Drop
          this.buttonsList.push({
            content: btn.nombre.toUpperCase(),
            effectAllowed: 'all',
            disable: false,
            handle: false,
          });
        });
    });
  }

  horizontalLayoutActive: boolean = false;
  private readonly verticalLayout: DropzoneLayout = {
    container: 'row',
    list: 'column',
    dndHorizontal: false,
  };
  layout: DropzoneLayout = this.verticalLayout;

  onDrop(event: DndDropEvent, list?: any[]) {
    if (list && (event.dropEffect === 'copy' || event.dropEffect === 'move')) {
      let index = event.index;

      if (typeof index === 'undefined') {
        index = list.length;
      }

      list.splice(index, 0, event.data);
    }
  }

  onDragged(item: any, list: any[], effect: DropEffect) {
    if (effect === 'move') {
      const index = list.indexOf(item);
      list.splice(index, 1);
    }
  }

  onDragStart(event:DragEvent) {
    console.log("drag started", JSON.stringify(event, null, 2));
  }

  onDragEnd(event:DragEvent) {
    console.log("drag ended", JSON.stringify(event, null, 2));
  }

}
