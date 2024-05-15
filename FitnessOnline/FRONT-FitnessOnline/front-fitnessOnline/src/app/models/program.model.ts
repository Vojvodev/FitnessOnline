import { Category } from "./category.model";

export class Program{
    id: number;
    name: string;
    description: string;
    category: Category;
    price: number;
    difficulty: string;
    duration: string;
    location: string;
    activityType: string;
    equipment: string;
    createdAt: string;
    bodyweight: boolean;
    image: string;
}