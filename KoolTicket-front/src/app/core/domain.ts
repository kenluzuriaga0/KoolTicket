export interface Sucursal {
    id: number;
    nombre: string;
    direccion: string;
    orden: number;
}

export interface Usuario {
    id: number;
    username: string;
    nombres: string;
    apellidos: string;
    cajaPrioridad: string;
}

export interface Boton {
    id: number;
    nombre: string;
    prefijoTicket: string;
    color: string;
    orden: number;
    estado: boolean;
}


