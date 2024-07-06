import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DndDropEvent, DndModule, DropEffect, EffectAllowed } from 'ngx-drag-drop';
import { polyfill } from 'mobile-drag-drop';
import { scrollBehaviourDragImageTranslateOverride } from "mobile-drag-drop/scroll-behaviour";

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

  buttons = ['CITAS MEDICAS', 'INFORMACIÓN', 'LABORATORIO', 'PRUEBAS COVID', 'OTROS SERVICIOS', 'DERIVACIONES']

  buttonsList: DraggableItem[] = [
    {
      content: 'CITAS MEDICAS',
      effectAllowed: 'all',
      disable: false,
      handle: false,
    },
    {
      content: 'INFORMACIÓN',
      effectAllowed: 'all',
      disable: false,
      handle: false,
    },
    {
      content: 'LABORATORIO',
      effectAllowed: 'all',
      disable: false,
      handle: false,
    },
    {
      content: 'PRUEBAS COVID',
      effectAllowed: 'all',
      disable: false,
      handle: false,
    },
    {
      content: 'OTROS SERVICIOS',
      effectAllowed: 'all',
      disable: false,
      handle: false,
    },
    {
      content: 'DERIVACIONES',
      effectAllowed: 'all',
      disable: false,
      handle: false,
    },
  ]

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
