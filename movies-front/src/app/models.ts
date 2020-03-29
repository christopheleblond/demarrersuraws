export interface Movie {
  id: string;
  title: string;
  year: number;
  storyline?: string;
  poster?: string;
  actors?: string[];
  genres?: string[];
  imbdRating?: number;
}
